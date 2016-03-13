/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.flume.sink.hive.batch.util;

import java.sql.*;

/**
 * Created by Tao Li on 2016/3/2.
 */
public class DBManager {
  private final String connectURL;
  private Connection conn = null;
  private Statement stmt = null;

  public DBManager(String connectURL) {
    this.connectURL = connectURL;
  }

  public void connect() throws SQLException {
    conn = DriverManager.getConnection(this.connectURL);
    stmt = conn.createStatement();
  }

  public void execute(String sql) throws SQLException {
    stmt.execute(sql);
  }

  public ResultSet executeQuery(String sql) throws SQLException {
    return stmt.executeQuery(sql);
  }

  public void close() throws SQLException {
    if (conn != null) {
      conn.close();
    }
  }
}
