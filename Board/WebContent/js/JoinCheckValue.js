/**
 *  회원 가입시 각각의 값 입력되어있는지 안되어 있는지 체크 & 비밀번호와 비밀번호가 일치 하는지 체크
 */
        function checkValue()
        {
            var idReg = /^[a-zA-Z]+[a-zA-Z0-9]{5,19}$/g;
            
            if(!document.userInfo.id.value){
                alert("아이디를 입력하세요.");
                return false;
            }

            if( !idReg.test(document.userInfo.id.value)) {
                alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
                return false;
            }
            
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
        function ReturnLoginForm() {
            location.href="/Board/MainForm.do?contentPage=/member/view/MemberLoginForm.jsp";
        }