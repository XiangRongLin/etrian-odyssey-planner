<template>
    <div>
        <PartyAdd @submit="onPartySubmit"></PartyAdd>
        <PartyList v-bind:newParty="newParty"></PartyList>
    </div>
</template>

<script>
    import PartyAdd from "@/components/PartyAdd";
    import PartyList from "@/components/PartyList";

    export default {
        name: "Party",
        components: {PartyAdd, PartyList},
        data() {
            return {
                newParty: Object
            }
        },
        methods: {
            async onPartySubmit(party) {
                this.newParty = party
            }
        },

    }
</script>

<style scoped>
</style>