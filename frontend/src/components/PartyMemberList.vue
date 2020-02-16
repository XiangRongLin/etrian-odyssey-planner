<template>
    <div>
        <md-toolbar :md-elevation="1">
            <span class="md-title">Party members</span>
        </md-toolbar>
        <md-list v-for="member in members" v-bind:key="member.member.id">
            <p>Name: {{member.member.name}} || Position: {{member.position}}</p>
        </md-list>
    </div>
</template>

<script>
    import {PartyService} from "@/api";

    export default {
        name: "PartyMemberList",
        props: {
            partyId: Number
        },
        data() {
            return {
                members: []
            }
        },
        mounted() {
            this.getMembers()
        },
        methods: {
            async getMembers() {
                PartyService.getMembers(this.partyId)
                    .then(response => {
                        this.members = response.data
                    });
            },
        }
    }
</script>

<style scoped>

</style>