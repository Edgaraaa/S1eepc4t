import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/challenge',
                    component: () => import(/* webpackChunkName: "challenge" */ '../components/page/Challenge.vue'),
                    meta: { title: '比赛赛题' }
                },
                {
                    path: '/rank',
                    component: () => import(/* webpackChunkName: "rank" */ '../components/page/Rank.vue'),
                    meta: { title: '比赛排名' }
                },
                {
                    path: '/addchallenge',
                    component: () => import(/* webpackChunkName: "addchallenge" */ '../components/page/AddChallengeAdmin.vue'),
                    meta: { title: '比赛排名' }
                },
                {
                    path: '/listchallenge',
                    component: () => import(/* webpackChunkName: "addchallenge" */ '../components/page/ListChallengeAdmin.vue'),
                    meta: { title: '所有赛题' }
                },
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
        {
            path: '/register',
            component: () => import(/* webpackChunkName: "register" */ '../components/page/Register.vue'),
            meta: { title: '注册' }
        },
        {
            path: '*',
            redirect: '/404'
        },
        {
            path: '/welcome',
            component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Welcome.vue'),
            meta: { title: '欢迎界面' }
        }
    ]
});
