<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-card shadow="hover" class="mgb20" style="height:252px;">
                    <div class="user-info">
                        <img src="../../assets/img/img.jpg" class="user-avator" alt />
                        <div class="user-info-cont">
                            <div class="user-info-name">{{this.tableDate.username}}</div>
                            <el-tag>{{role}}</el-tag>
                        </div>
                    </div>
                    <div class="user-info-list">
                        所属战队  ：
                        <span>{{this.tableDate.teamname}}</span>
                    </div>
                    <div class="user-info-list">
                        uid:
                        <span>{{this.uids}}</span>
                    </div>
                </el-card>
                <el-card shadow="hover" style="height:330px;">
                    <div slot="header" class="clearfix">
                        <span>解题比例</span>
                    </div>
                    WEB
                    <el-progress :percentage="71.3" color="#42b983"></el-progress>
                    PWN
                    <el-progress :percentage="24.1" color="#f1e05a"></el-progress>
                    RE
                    <el-progress :percentage="13.7"></el-progress>
                    MISC
                    <el-progress :percentage="5.9" color="#f56c6c"></el-progress>
                    CRYPTO
                    <el-progress :percentage="5.9" color="#f56c6e"></el-progress>
                </el-card>
            </el-col>
            <el-col :span="16">
                <el-row :gutter="20" class="mgb20">
                    <el-col :span="12">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-1">
                                <i class="el-icon-trophy grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">{{this.tableDate.score}}</div>
                                    <div>当前分数</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="12">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-2">
                                <i class="el-icon-medal grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">{{this.rank}}</div>
                                    <div>当前排名</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
                <el-card shadow="hover" style="height:600px;">
                    <div slot="header" class="clearfix">
                        <span>比赛通知</span>
                        <el-button style="float: right; padding: 3px 0" type="text">添加</el-button>
                    </div>
                    <el-table :show-header="false" :data="todoList" style="width:100%;">
                        <el-table-column width="40">
                            <template slot-scope="scope">
                                <el-checkbox v-model="scope.row.status"></el-checkbox>
                            </template>
                        </el-table-column>
                        <el-table-column>
                            <template slot-scope="scope">
                                <div
                                    class="todo-item"
                                    :class="{'todo-item-del': scope.row.status}"
                                >{{scope.row.title}}</div>
                            </template>
                        </el-table-column>
                        <el-table-column width="60">
                            <template>
                                <i class="el-icon-edit"></i>
                                <i class="el-icon-delete"></i>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import Schart from 'vue-schart';
import bus from '../common/bus';
import GLOBAL from '../../api/global_var'
import axios from 'axios';
export default {
    name: 'dashboard',
    created(){
        this.getUser()
        this.getRank()
    },
    data() {
        return {
            tableDate:null,
            rank:1,
            uids:'',
            todoList: [
                {
                    title: '比赛平台前端已经在写了',
                    status: false
                },
                {
                    title: '',
                    status: false
                },
                {
                    title: '不会有人取消比赛资格了吧',
                    status: false
                },
                {
                    title: '后端已经开始写了',
                    status: false
                },
                {
                    title: '表示弟弟已经吐了',
                    status: true
                },
                {
                    title: '今天要写100行代码加几个bug吧',
                    status: true
                }
            ],
        };
    },
    components: {
        Schart
    },
    computed: {
        role() {
            return this.tableDate.username === 'admin' ? '超级管理员' : '普通用户';
        }
    },
    // created() {
    //     this.handleListener();
    //     this.changeDate();
    // },
    // activated() {
    //     this.handleListener();
    // },
    // deactivated() {
    //     window.removeEventListener('resize', this.renderChart);
    //     bus.$off('collapse', this.handleBus);
    // },
    methods: {
        changeDate() {
            const now = new Date().getTime();
            this.data.forEach((item, index) => {
                const date = new Date(now - (6 - index) * 86400000);
                item.name = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()}`;
            });
        },
        getUser(){
            let date = new FormData();
            var that=this
            let token=localStorage.getItem('ms_token');
            date.append('token',token);
            axios.post('http://127.0.0.1:8080/testBoot/getUserInfo?token='+token).then(function(response){
                that.tableDate=response.data
                localStorage.setItem('ms_uid', response.data["uid"]);
                that.uids=response.data["uid"]
            });
        },
        getRank(){
            let date = new FormData();
            var that=this
            let token=localStorage.getItem('ms_token');
            let uid = localStorage.getItem('ms_uid')
            date.append('uid',uid)
            axios.post('http://127.0.0.1:8080/api/rank/getTeamRank?token='+token,date).then(function(response){
                console.log(response.data)
                that.rank=response.data
            });
        }
        // handleListener() {
        //     bus.$on('collapse', this.handleBus);
        //     // 调用renderChart方法对图表进行重新渲染
        //     window.addEventListener('resize', this.renderChart);
        // },
        // handleBus(msg) {
        //     setTimeout(() => {
        //         this.renderChart();
        //     }, 200);
        // },
        // renderChart() {
        //     this.$refs.bar.renderChart();
        //     this.$refs.line.renderChart();
        // }
    }
};
</script>


<style scoped>
.el-row {
    margin-bottom: 20px;
}

.grid-content {
    display: flex;
    align-items: center;
    height: 100px;
}

.grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
}

.grid-num {
    font-size: 30px;
    font-weight: bold;
}

.grid-con-icon {
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
    color: #fff;
}

.grid-con-1 .grid-con-icon {
    background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
    background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
    background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
    color: rgb(242, 94, 67);
}

.user-info {
    display: flex;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
}

.user-avator {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}

.user-info-cont {
    padding-left: 50px;
    flex: 1;
    font-size: 14px;
    color: #999;
}

.user-info-cont div:first-child {
    font-size: 30px;
    color: #222;
}

.user-info-list {
    font-size: 14px;
    color: #999;
    line-height: 25px;
}

.user-info-list span {
    margin-left: 70px;
}

.mgb20 {
    margin-bottom: 20px;
}

.todo-item {
    font-size: 14px;
}

.todo-item-del {
    text-decoration: line-through;
    color: #999;
}

.schart {
    width: 100%;
    height: 300px;
}
</style>
