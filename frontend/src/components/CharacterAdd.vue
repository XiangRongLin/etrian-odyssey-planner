<template>
    <div>
        <h3>New Character</h3>
        <span>name   </span><input v-model="newName">
        <button v-on:click="submitNewCharacter">Submit</button>
    </div>
</template>

<script>
    import {CharacterService} from "@/api";

    export default {
        name: "CharacterAdd",
        data() {
            return {
                newName: ''
            }
        },
        methods: {
            async submitNewCharacter() {
                CharacterService.create({
                    name: this.newName
                }).then(response => {
                    this.$emit('submit',
                        {
                            id: response.data,
                            name: this.newName
                        })
                })
            }
        }
    }
</script>

<style scoped>

</style>