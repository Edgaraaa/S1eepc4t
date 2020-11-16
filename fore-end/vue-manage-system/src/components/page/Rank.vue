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
        label="Name"
        prop="name">
        </el-table-column>
        <el-table-column
        label="Team"
        prop="team">
        </el-table-column>
        <el-table-column
        label="Score"
        prop="score">
        </el-table-column>
        <el-table-column
        label="Solves"
        prop="solves">
        </el-table-column>
        <el-table-column
        label="Time"
        prop="date">
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
  export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          team:"Dozer",
          score:123,
          solves:3,
          name: 'Edgar',
        }, {
          date: '2016-05-04',
          name: 'Andy',
          team:"Dozer",
          score:123,
          solves:3
        }, {
          date: '2016-05-01',
          name: 'Faker',
          team:"Dozer",
          score:123,
          solves:3
        }, {
          date: '2016-05-03',
          name: 'Joker',
          team:"Dozer",
          score:123,
          solves:3
        }],
        search: ''
      }
    },
    methods: {
        setCurrent(row) {
        this.$refs.singleTable.setCurrentRow(row);
      },
      handleCurrentChange(val) {
        this.currentRow = val;
      }
    },
  }
</script>