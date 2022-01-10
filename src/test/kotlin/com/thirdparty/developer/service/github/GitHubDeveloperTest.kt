package com.thirdparty.developer.service.github

import org.junit.Test

/**
 * Created by jennifer.huang on 2022/1/9.
 */
class GitHubDeveloperTest {

    @Test
    fun testGitHubApi() {
        val gitHubDeveloper = GitHubDeveloper()
        gitHubDeveloper.createAnIssue("gitHubApiIssueTitle2", "gitHubApiIssueBody2")
    }
}