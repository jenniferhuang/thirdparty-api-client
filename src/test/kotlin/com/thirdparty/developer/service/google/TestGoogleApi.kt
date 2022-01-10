package com.thirdparty.developer.service.google

import com.google.api.services.sheets.v4.model.ValueRange
import org.junit.Test

/**
 * Created by jennifer.huang on 2022/1/8.
 */
class TestGoogleApi {
    //Google example: https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit#gid=0
    val spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms"
    val range = "Class Data!A2:E" // 读取的表格范围，命名规范： {sheet表名称}!{开始单元格}:{结束单元格}


    @Test
    fun testGoogleAPi() {
        val sheetClient = GoogleClient().getGoolgeSheetClient()
        val response: ValueRange = sheetClient.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute()

        val values = response.getValues()
        if (values == null || values.isEmpty()) {
            println("No data found.")
        } else {
            println("Name, Major")
            for (row in values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row[0], row[4])
            }
        }
    }
}