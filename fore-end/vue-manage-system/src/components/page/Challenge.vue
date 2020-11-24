<template>
      <el-table
        border
        ref="singleTable"
        :data="tableData"
        highlight-current-row
        @current-change="handleCurrentChange"
        style="width: 100%">
        <el-table-column
          type="index"
          width="80">
          
        </el-table-column>
        <el-table-column
          property="cid"
          label="题目ID"
          width="100">
        </el-table-column>
        <el-table-column
          property="titles"
          label="题目名称"
          width="800">
          <template slot-scope="{row}">
            <el-button type="text" @click="open(row.describution,row.titles)">{{ row.titles }}</el-button>

          </template>
        </el-table-column>
        <el-table-column
          property="challengeType"
          label="题目类型"
          width="250">
          <template slot-scope="{row}">
            <el-tag>{{ row.challengeType }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          property="score"
          label="分值"
          width="100">
        </el-table-column>
        <el-table-column
          property="deal"
          label="解决人数"
          width="100">
        </el-table-column>
        
      </el-table>
      
      
</template>

<style>

</style>


<script>
import axios from 'axios';
export default {
  created(){
    var that=this;
    axios.get('http://127.0.0.1:8080/api/challenge//getAllChallenge').then(function(response){
      that.tableData=response.data;
    });
  },
  data() {
    return {
      tableData:[{}],
      dialogVisible: false
    };
  },
  methods: {
        deleteRow(index, rows) {
        rows.splice(index, 1);
      },
       handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      open(str1,str2) {
        const h = this.$createElement;
        this.$msgbox({
          title: str2,
          message: h('p', null, [
            h('span', null, '内容可以是 '),
            h('i', { style: 'color: teal' }, str1)
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
            if (action === 'confirm') {
              instance.confirmButtonLoading = true;
              instance.confirmButtonText = '执行中...';
              setTimeout(() => {
                done();
                setTimeout(() => {
                  instance.confirmButtonLoading = false;
                }, 300);
              }, 3000);
            } else {
              done();
            }
          }
        }).then(action => {
          this.$message({
            type: 'info',
            message: 'action: ' + action
          });
        });
      }
  }
}
</script>