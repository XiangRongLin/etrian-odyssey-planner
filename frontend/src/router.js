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
            name: "party-overview",
            component: () => import("@/components/PartyOverview")
        },
        {
            path: "/party/:id",
            name: "party",
            component: () => import("@/components/Party"),
            props: true
        },
        {
            path: "/character",
            name: "character-overview",
            component: () => import("@/components/CharacterOverview"),
        },
        // {
        //     path: "/character/:id",
        //     name: "character",
        //     component: () => import("@/components/Character"),
        // },

    ]
})