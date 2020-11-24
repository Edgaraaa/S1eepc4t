<template>

    <el-table
        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%"
        highlight-current-row
        @current-change="handleCurrentChange"
        >
        <div :id="id" :option="option" class="mychart"></div>
        <el-table-column
        type="index"
        width="50">
        </el-table-column>
        <el-table-column
        label="tid"
        prop="tid">
        </el-table-column>
        <el-table-column
        label="Team Name"
        prop="teamName">
        </el-table-column>
        <el-table-column
        label="队长id"
        prop="uid">
        </el-table-column>
        <el-table-column
        label="score"
        prop="score">
        </el-table-column>
        <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
            <el-input
            v-model="search"
            size="mini"
            placeholder="输入关键字搜索"/>
        </template>
        </el-table-column>
    </el-table>
</template>

<script>
import axios from 'axios';
  export default {
    created() {
      this.getDate();
    },
    data() {
      return {
        id:"",
        one: {},
        tableData: [],
        search: ''
      }
    },
    methods: {
      getDate(){
        var that=this;
        axios.get('http://localhost:8080/api/rank/getRank').then(function(response) {
        that.tableData=response.data;
      });
      },
        setCurrent(row) {
        this.$refs.singleTable.setCurrentRow(row);
      },
      handleCurrentChange(val) {
        this.currentRow = val;
      },
      timer() {
        return setTimeout(()=>{
          this.getDate()
        },5000)
      }
    },
    watch: {
      tableData() {
      this.timer() 
      }
    },
    destroyed() {
  clearTimeout(this.timer)
    }
  }
</script>