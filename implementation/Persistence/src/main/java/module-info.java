module persistence_module { 
    requires datarecords_module;
    requires java.sql;
    requires java.base;
    requires org.postgresql.jdbc;
    exports persistence;
}
