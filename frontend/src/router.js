import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);
export default new Router({
    routes: [
        {
            path: "/",
            name: "home",
            component: () => import("@/components/Home")
        },
        {
            path: "/party",
            name: "party-list",
            component: () => import("@/components/PartyList")
        },
        {
            path: "/party/:id",
            name: "party",
            component: () => import("@/components/Party"),
            props: true
        }
    ]
})