<template>
    <div>
        <router-link :id="id" :to="partyLink">{{name}}</router-link>
    </div>
</template>

<script>
    export default {
        name: "PartyPreview",
        props: {
            id: Number,
            name: String
        },
        computed: {
            partyLink() {
                return {
                    name: 'party',
                    params: {
                        id: this.id,
                        name: this.name
                    }
                }
            }
        }
    }
</script>

<style scoped>

</style>