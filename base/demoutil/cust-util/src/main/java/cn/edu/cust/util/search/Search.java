package cn.edu.cust.util.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;


public abstract class Search {
	protected String[] logicalopts;//逻辑运算符
	protected String[] columns;//列名,如果某列不选择，则此列取值为"-"
	protected String[] operators;//算术运算符
	protected String[] values;//值
	protected String[] orders;//排序
	protected static Map<String, Operator> operatorsMap;
	protected static Set<String> ordersSet;
	protected static Set<String> logicaloptsSet;

	protected abstract Map<String, ColumnType> getColumnsSet();
	protected abstract String getTables();
	protected abstract String getProjections();
	
	private Logger log = Logger.getLogger(Search.class);
	
	static {
		//算术运算符取值
		operatorsMap = new HashMap<String, Operator>();
		operatorsMap.put("eq", Operator.EQ);
		operatorsMap.put("ne", Operator.NE);
		operatorsMap.put("gt", Operator.GT);
		operatorsMap.put("ge", Operator.GE);
		operatorsMap.put("lt", Operator.LT);
		operatorsMap.put("le", Operator.LE);
		operatorsMap.put("like", Operator.LIKE);
		
		//排序取值
		ordersSet = new HashSet<String>();
		ordersSet.add("none");//不排序
		ordersSet.add("desc");
		ordersSet.add("asc");
		
		//逻辑运算符取值
		logicaloptsSet = new HashSet<String>();
		logicaloptsSet.add("and");
		logicaloptsSet.add("or");
	}
	
	private ColumnType[] cts;
	private Operator[] opts;
	
	public String buildSQL(){
		return buildSQL(null);
	}
	
	public String buildSQL(String whereClause){
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(getProjections());
		sql.append(" from ");
		sql.append(getTables());
		Map<String, ColumnType> cs = getColumnsSet();
		if(columns != null && columns.length > 0){
			boolean addWhere = false;
			int columnslen = columns.length;
			log.info("columnslen: " + columnslen);
			cts = new ColumnType[columnslen];
			opts = new Operator[columnslen];
			for (int i = 0; i < columnslen; i++) {
				String column = columns[i];
				log.info("column: " + column);
				if("-".equals(column)){// 如果不选择搜索列
					continue;
				}
				if(addWhere){
					sql.append(" ");
					String logicalopt = logicalopts[i];
					if(!logicaloptsSet.contains(logicalopt)){
						throw new RuntimeException("logicalopt is valid: " + logicalopt);
					}
					sql.append(logicalopt);
					sql.append(" ");
				}else{
					addWhere = true;
					sql.append(" where ");
				}
				ColumnType ct = cs.get(column);
				
				log.info("ct:   "+ct);
				cts[i] = ct;
				if(ct == null){
					throw new RuntimeException("column is valid: " + column);
				}
				
				//处理like 模糊查询 如果是字符串 需要包裹上%
				if(ct == ColumnType.STRING) {
					if("like".equals(operators[i])) {
						values[i] = "%" + values[i] + "%";
					}
				}
				sql.append(column);
				
				String operator = operators[i];
				Operator opt = operatorsMap.get(operator);
				opts[i] = opt;
				if(opt == null){
					throw new RuntimeException("operator is valid: " + operator);
				}
				opt.appendSQL(sql);
				
			}
			if(whereClause != null){
				if (addWhere) {
					sql.append(" and " + whereClause);
				} else {
					sql.append(" where " + whereClause);
				}
			}
			boolean addOrder = false;
			for (int i = 0; i < columnslen; i++) {
				if(cts[i] == null){// 如果不选择搜索列
					continue;
				}
				String order = orders[i];
				if(!ordersSet.contains(order)){
					throw new RuntimeException("order is valid: " + order);
				}
				if("none".equals(order)){
					continue;
				}
				if(addOrder){
					sql.append(", ");
				}else{
					addOrder = true;
					sql.append(" order by ");
				}
				sql.append(columns[i]);
				sql.append(" ");
				sql.append(order);
			}
		}
		
		
		return sql.toString();
	}
	
	
	public ArrayList<Object> getParams(){
		if(cts == null){
			return new ArrayList<Object>();
		}
		int ctslen = cts.length;
		int valueIndex = 0;
		ArrayList<Object> params = new ArrayList<Object>();
		for (int i = 0; i < ctslen; i++) {
			if(cts[i] != null){
				params.add(cts[i].getValue(values[valueIndex]));
				int numOfParams = opts[i].getNumOfParams();
				valueIndex += numOfParams;
			}else{
				valueIndex++;
			}
		}
		return params;
	}
	
	public String[] getLogicalopts() {
		return logicalopts;
	}
	public void setLogicalopts(String[] logicalopts) {
		this.logicalopts = logicalopts;
	}
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public String[] getOperators() {
		return operators;
	}
	public void setOperators(String[] operators) {
		this.operators = operators;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	public String[] getOrders() {
		return orders;
	}
	public void setOrders(String[] orders) {
		this.orders = orders;
	}
}
