package org.brokenarrow.storage.api.util.builderclass;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class Databasewrapper {
	private TableWrapper table;

	private Databasewrapper() {
		//throw new Validate.CatchExceptions("You should not try create empty constractor");
	}

	public Databasewrapper(@NotNull String tableName, @NotNull String primaryKey, boolean isSQlittle) {
		this.table = new TableWrapper(tableName, primaryKey, isSQlittle);
	}

	/**
	 * Method to create new database command. Will create first part of the table. You need then use methods
	 * {@link TableWrapper#add(String, String)}, {@link TableWrapper#addNotNull(String, String)}
	 * {@link TableWrapper#addDefult(String, String, String)}, {@link TableWrapper#addAutoIncrement(String, String)}
	 * and lastly use this {@link TableWrapper#createTable()}. To build the string for the database command.
	 *
	 * @param tableName  name on your table.
	 * @param primaryKey key some is primary if not set you can add duplicate records.
	 * @param isSQlittle some commands are not suported in SQlittle (so need to know what type of database).
	 * @return TableWrapper class you need then add columms to your table.
	 */
	public static TableWrapper of(@NotNull String tableName, @NotNull String primaryKey, boolean isSQlittle) {
		return new Databasewrapper(tableName, primaryKey, isSQlittle).getTableWrapper();
	}

	/**
	 * Method to create new database command. Will create first part of the table. You need then use method
	 * {@link TableWrapper#save(String, Object)} and {@link TableWrapper#replaceIntoTable()} to build the string for the database command.
	 *
	 * @param tableName  name on your table.
	 * @param isSQlittle some commands are not suported in SQlittle (so need to know what type of database).
	 * @return TableWrapper class you need then add columms to your table.
	 */
	public static TableWrapper of(@NotNull String tableName, boolean isSQlittle) {
		return new Databasewrapper(tableName, "non", isSQlittle).getTableWrapper();
	}

	/**
	 * Method to create new database command. Will create first part of the table. You need then use methods like
	 * {@link TableWrapper#add(String, String)}, {@link TableWrapper#addNotNull(String, String)}  {@link TableWrapper#addDefult(String, String, String)},
	 * {@link TableWrapper#addAutoIncrement(String, String)} ,{@link TableWrapper#save(String, Object)}
	 * <p>
	 * <p>
	 * <p>
	 * and lastly use this {@link TableWrapper#replaceIntoTable()} , {@link TableWrapper#updateTable()} or
	 * {@link TableWrapper#createTable()} to build the string for the database command.
	 *
	 * @param tableName  name on your table.
	 * @param isSQlittle some commands are not suported in SQlittle (so need to know what type of database).
	 * @return TableWrapper class you need then add columms to your table.
	 */

	public static TableWrapper of(@NotNull String tableName, @NotNull String primaryKey, @NotNull String record, boolean isSQlittle) {
		return new Databasewrapper(tableName, primaryKey, isSQlittle).getTableWrapper().setRecord(record);
	}

	public TableWrapper getTableWrapper() {
		return table;
	}

	public static final class TableRow {

		private final String columnName;
		private final String defaultValue;
		/**
		 * Datatype you store the value.
		 */
		private final String datatype;
		private final boolean primaryKey;
		private final boolean autoIncrement;
		private final boolean notNull;

		public TableRow(Builder builder) {
			this.columnName = builder.columnName;
			this.defaultValue = builder.defaultValue;
			this.datatype = builder.datatype;
			this.primaryKey = builder.primaryKey;
			this.autoIncrement = builder.autoIncrement;
			this.notNull = builder.notNull;
		}

		public String getColumnName() {
			return columnName;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public String getDatatype() {
			return datatype;
		}

		public boolean isPrimaryKey() {
			return primaryKey;
		}

		public boolean isAutoIncrement() {
			return autoIncrement;
		}

		public boolean isNotNull() {
			return notNull;
		}

		public static class Builder {
			private final String columnName;
			private String defaultValue;
			/**
			 * Datatype you store the value.
			 */
			private final String datatype;
			private boolean primaryKey;
			private boolean autoIncrement;
			private boolean notNull;

			public Builder(String columnName, String datatype) {
				this.columnName = columnName;
				this.datatype = datatype;
			}

			public Builder setDefaultValue(String defaultValue) {
				this.defaultValue = defaultValue;
				return this;
			}

			public Builder setPrimaryKey(boolean primaryKey) {
				this.primaryKey = primaryKey;
				return this;
			}

			public Builder setAutoIncrement(boolean autoIncrement) {
				this.autoIncrement = autoIncrement;
				return this;
			}

			public Builder setNotNull(boolean notNull) {
				this.notNull = notNull;
				return this;
			}

			public TableRow build() {
				return new TableRow(this);
			}

		}

	}

	public static final class TableWrapper {
		private final String primaryKey;
		private final String tableName;
		private String record;
		private String columnsArray;
		private final boolean SQLite;
		private final List<TableRow> columns = new ArrayList<>();

		public TableWrapper(@NotNull String tableName, @NotNull String primaryKey, boolean isSQLite) {
			//	checkNotEmpty(tableName, "Table name is empty.");
			//	checkNotEmpty(primaryKey, "Primary key is empty, if you not set this you can't have unique rows in the database.");
			this.SQLite = isSQLite;
			this.tableName = tableName;
			this.primaryKey = primaryKey;
		}

		public TableWrapper add(String columnName, String datatype) {
			columns.add(new TableRow.Builder(columnName, datatype).setPrimaryKey(getPrimaryKey().equals(columnName)).build());
			return this;
		}

		public TableWrapper addDefult(String columnName, String datatype, String defult) {
			columns.add(new TableRow.Builder(columnName, datatype).setPrimaryKey(getPrimaryKey().equals(columnName)).setDefaultValue(defult).build());
			return this;
		}

		public TableWrapper addAutoIncrement(String columnName, String datatype) {
			columns.add(new TableRow.Builder(columnName, datatype).setPrimaryKey(getPrimaryKey().equals(columnName)).setAutoIncrement(true).build());
			return this;
		}

		public TableWrapper addNotNull(String columnName, String datatype) {
			columns.add(new TableRow.Builder(columnName, datatype).setPrimaryKey(getPrimaryKey().equals(columnName)).setNotNull(true).build());
			return this;
		}

		public TableWrapper save(String columnName, Object dataToSave) {
			columns.add(new TableRow.Builder(columnName, dataToSave + "").build());
			return this;
		}

		public TableWrapper setRecord(String record) {
			this.record = record;
			return this;
		}

		public String getPrimaryKey() {
			return primaryKey;
		}

		public String getRecord() {
			return record;
		}

		public String getTableName() {
			return tableName;
		}

		public List<TableRow> getColumns() {
			return columns;
		}

		public String getColumnsArray() {
			return columnsArray;
		}

		public boolean isSQLite() {
			return SQLite;
		}

		/**
		 * Create new table with columns,data type and primary key you have set.
		 * From this methods {@link #add(String, String)}, {@link #addNotNull(String, String)}
		 * {@link #addDefult(String, String, String)} {@link #addAutoIncrement(String, String)}
		 *
		 * @return string with prepered query to run on your database.
		 */
		public String createTable() {
			StringBuilder columns = new StringBuilder();

			for (final TableRow column : this.getColumns()) {
				columns.append((columns.length() == 0) ? "" : ", ").append("`").append(column.getColumnName()).append("` ").append(column.getDatatype());

				if (column.isAutoIncrement())
					columns.append(" NOT NULL AUTO_INCREMENT");

				else if (column.isNotNull())
					columns.append(" NOT NULL");

				if (column.getDefaultValue() != null)
					columns.append(" DEFAULT ").append(column.getDefaultValue());
			}
			//	checkBoolean(getPrimaryKey() == null  ||  getPrimaryKey().equals("non"), "You need set primaryKey, for create a table.");
			columns.append(", PRIMARY KEY (`").append(getPrimaryKey()).append("`)");

			columnsArray = this.columns.stream().map(TableRow::getColumnName).collect(Collectors.joining(","));
			return "CREATE TABLE IF NOT EXISTS `" + this.getTableName() + "` (" + columns + ")" + (this.isSQLite() ? "" : " DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci") + ";";

		}

		/**
		 * Replace data in your database, on columns you added with {@link #save(String, Object)}.
		 *
		 * @return string with prepered query to run on your database.
		 */
		public String replaceIntoTable() {
			StringBuilder columns = new StringBuilder();
			StringBuilder values = new StringBuilder();
			for (int index = 0; index < this.getColumns().size(); index++) {
				TableRow column = this.getColumns().get(index);
				boolean endOfString = index + 1 == this.getColumns().size();
				columns.append((columns.length() == 0) ? "(" : "").append("`").append(column.getColumnName()).append("`").insert(columns.length(), columns.length() == 0 || endOfString ? "" : ",");
				values.append(column.getDatatype()).insert(values.length(), values.length() == 0 || endOfString ? "" : "','");
			}
			columns.insert(columns.length(), ") VALUES('" + values + "')");
			return "REPLACE INTO `" + this.getTableName() + "` " + columns + ";";
		}

		/**
		 * Update data in your database, on columns you added with {@link #save(String, Object)}. Will replace old data on colums you added.
		 *
		 * @return string with prepered query to run on your database.
		 */
		public String updateTable() {
			//	checkBoolean(getPrimaryKey() == null  ||  getPrimaryKey().equals("non"), "You need set primary key, for update records in the table or all records get updated.");
			//	checkBoolean(this.record == null  ||  this.record.isEmpty(), "You need set record name, for update records in the table.");
			StringBuilder columns = new StringBuilder();
			for (int index = 0; index < this.getColumns().size(); index++) {
				TableRow column = this.getColumns().get(index);
				boolean endOfString = index + 1 == this.getColumns().size();
				columns.append("`").append(column.getColumnName()).append("`").insert(columns.length(), columns.length() == 0 || endOfString ? " = '" + column.getDatatype() + "'" : " = '" + column.getDatatype() + "',");
			}
			return "UPDATE `" + this.getTableName() + "` SET " + columns + " WHERE `" + getPrimaryKey() + "` = `" + this.record + "`" + ";";
		}
	}
}
