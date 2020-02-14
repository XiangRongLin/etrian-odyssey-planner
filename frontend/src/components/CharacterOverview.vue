<template>
    <div>
        <CharacterAdd @submit="onCharacterSubmit"></CharacterAdd>
        <CharacterList v-bind:newCharacter="newCharacter"></CharacterList>
    </div>
</template>

<script>
    import CharacterAdd from "@/components/CharacterAdd";
    import CharacterList from "@/components/CharacterList";

    export default {
        name: "CharacterOverview",
        components: {CharacterList, CharacterAdd},
        data() {
            return {
                newCharacter: Object
            }
        },
        methods: {
            async onCharacterSubmit(character) {
                this.newCharacter = character;
            }
        }
    }
</script>

<style scoped>

</style>