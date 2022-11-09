/*
 * Copyright 2020 by OLTPBenchmark Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.queries;

import com.oltpbenchmark.api.SQLStmt;

import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.item;
import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.nation;
import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.oorder;
import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.order_line;
import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.stock;
import static com.oltpbenchmark.benchmarks.chbenchmarkForSpark.chbenchmark.TableNames.supplier;

public class Q9 extends GenericQuery {

    private static final Boolean IF_IS_NEED_COMMIT = false;

    @Override
    public Boolean get_isCommit() {
        return IF_IS_NEED_COMMIT;
    }

    public final SQLStmt query_stmt = new SQLStmt(
        "SELECT n_name, "
            + "extract(YEAR "
            + "FROM o_entry_d) AS l_year, "
            + "sum(ol_amount) AS sum_profit "
            + "FROM " +item() + ", "
            + "" +stock() + ", "
            + "" +supplier() + ", "
            + "" +order_line() + ", "
            + "" +oorder() + ", "
            + "" +nation() + " "
            + "WHERE ol_i_id = s_i_id "
            + "AND ol_supply_w_id = s_w_id "
            + "AND MOD ((s_w_id * s_i_id), 10000) = su_suppkey "
            + "AND ol_w_id = o_w_id "
            + "AND ol_d_id = o_d_id "
            + "AND ol_o_id = o_id "
            + "AND ol_i_id = i_id "
            + "AND su_nationkey = n_nationkey "
            + "AND i_data LIKE '%bb' "
            + "GROUP BY n_name, "
            + "extract(YEAR FROM o_entry_d) "
            + "ORDER BY n_name, "
            + "extract(YEAR FROM o_entry_d)  DESC"
    );

    protected SQLStmt get_query() {
        return query_stmt;
    }
}
