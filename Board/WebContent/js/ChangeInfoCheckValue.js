/**
 *  
 */
        function checkValue()
        {
           
            if(!document.userInfo.password.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }

            if(document.userInfo.password.value != document.userInfo.passwordcheck.value ){
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }
            
            if(!document.userInfo.email.value ){
                alert("이메일을 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.name.value){
                alert("이름을 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.birthday.value){
                alert("생년원일를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.gender.value){
                alert("성별을 입력하세요.");
                return false;
            }
        }
