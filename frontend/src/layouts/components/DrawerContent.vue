<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '블로그 관리' }" />
        <VerticalNavLink
            :item="{
                title: '블로그',
                to: '/blogmanagements/blogs',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '블로그 읽기',
                to: '/blogmanagements/blogReads',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'BlogReadModel',
                to: '/blogmanagements/blogReadModels',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '게시물 관리' }" />
        <VerticalNavLink
            :item="{
                title: '게시물',
                to: '/postmanagements/posts',
            }"
        />
    </ul>
</template>
