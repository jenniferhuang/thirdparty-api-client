package com.thirdparty.developer.service.github

/**
 * Created by jennifer.huang on 2022/1/9.
 */

/**
 * 1. personal: https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps#non-web-application-flow
 * note; request to     "https://api.github.com"
 * 2. https://docs.github.com/en/developers/apps/building-oauth-apps/authorizing-oauth-apps --//your app; access thrid party app(github)
 * see: https://github.com/jenniferhuang/git-developer "Jennifer-App-Test"
 */
class GitHubDeveloper {

    val gitUser = "jenniferhuang"
    val gitPersonToken = "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"
    val gitRepository = "https://api.github.com/repos/jenniferhuang/git-developer/issues"

    fun createAnIssue(issueTitle: String, issueBody: String) {
        val commands = """
            curl -u '$gitUser:$gitPersonToken' 
            --location --request POST '$gitRepository' \
            --header 'Content-Type: application/json' \
            --data-raw '{
              "title": "$issueTitle",
              "body": "$issueBody"
            }'
        """
        println(commands)
        val process: Process = Runtime.getRuntime().exec(commands)
        var i: Int
        val sb = StringBuffer()
        while (process.inputStream.read().also { i = it } != -1) {
            sb.append(i as Char + "a")
        }
        println(sb.toString())
        process.destroy()
    }
}