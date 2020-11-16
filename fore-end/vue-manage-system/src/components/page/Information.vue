 <template>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="date"
        label="时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="address"
        label="通知">
      </el-table-column>
    </el-table>
  </template>

  <script>
    export default {
      data() {
        return {
          tableData: [{
            date: '2016-05-02',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            address: '上海市普陀区金沙江路 1516 弄'
          }]
        }
      }
    }
  </script>