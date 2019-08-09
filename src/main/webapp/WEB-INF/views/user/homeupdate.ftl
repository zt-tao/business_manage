<html>
<#include "common/header.ftl">

<body>


<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">

                    <form action="" method="post">
                        <input type="hidden" name="id" value="${userInfo.id}"><br/>
                        名称<input type="text" name="username" value="${userInfo.username}"><br/>
                        密码<input type="password" name="password" value="${userInfo.password}"><br/>
                        密保问题:<input type="text" name="question" value="${userInfo.question}"><br/>
                        密保答案:<input type="password" name="answer" value="${userInfo.answer}"><br/>
                        <input type="submit"  value="修改"><br/>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
