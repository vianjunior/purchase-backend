package com.junior.purchaseworkflow.utils;

public class PurchaseUtils
{
	private static String defaultSQL = "select * from ";
	private static String defaultWhere = "where 1=1";

	public static String buildQueryByFilter(String tableName, String filter) {
		String sql = defaultSQL + tableName;
		if (filter.isBlank() || filter.isEmpty()) {

		}
		return sql;
	}
}
