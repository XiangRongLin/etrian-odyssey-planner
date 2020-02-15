<template>
    <md-list-item :id=id :to="partyLink">
            <span class="md-list-item-text">
                {{name}}
            </span>
    </md-list-item>
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