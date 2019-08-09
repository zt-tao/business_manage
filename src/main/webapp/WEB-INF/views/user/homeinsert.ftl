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

                        <input type="hidden" name="id" value=""><br/>
                        名称<input type="text" name="username" value=""><br/>
                        密码<input type="password" name="password" value=""><br/>
                        邮箱:<input type="text" name="email" value=""><br/>
                        电话:<input type="text" name="phone" value=""><br/>
                        密保问题:<input type="text" name="question" value=""><br/>
                        密保答案:<input type="password" name="answer" value=""><br/>
                        身份:<input type="text" name="role" value=""><br/>
                        <input type="submit"  value="增加"><br/>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
