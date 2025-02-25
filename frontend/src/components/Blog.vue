<template>
    <div>
        <String label="이름" v-model="value.name" :editMode="editMode"/>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <String label="방문자이름" v-model="visitNameInput" :editMode="editMode" @keydown.enter="addVisitNameList"/>
            <v-card v-if="value.visitName.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>방문자이름 List</v-card-sub-title>
                <li v-for="(name, index) in value.visitName" :key="index">{{ name }}</li>
            </v-card>
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addVisitNameList">VisitName 추가</v-btn>
            </v-row>
            <StringDetailGrid label="VisitName" offline v-model="value.visitName" :editMode="editMode" @change="change"/>
        </div>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <PostId v-model="postIdInput"
                offline
                label="postId"
                :editMode="editMode"
                @change="change"
            />
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addPostIdList">postId Add</v-btn>
            </v-row>
            <v-card v-if="value.postId.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    postId List
                </v-card-sub-title>
                <li v-for="(id, index) in value.postId" :key="index">{{ id }}</li>
            </v-card>
        </div>
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Blog',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "blogs",
        visitNameInput: null,
        postIdInput: null,
        value: {
            visitName: [],
            postId: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addVisitNameList() {
            if (this.visitNameInput !== null && this.visitNameInput !== '') {
                this.value.visitName.push(this.visitNameInput);
                this.visitNameInput = null; // null로 초기화
            }
        },
        addPostIdList() {
            if (this.postIdInput !== null && this.postIdInput !== '') {
                this.value.postId.push(this.postIdInput);
                this.postIdInput = null; // null로 초기화
            }
        },
    },
}
</script>
