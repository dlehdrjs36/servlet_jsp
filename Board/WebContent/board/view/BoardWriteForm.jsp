<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
<script type="text/javascript" src="./se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>

<body>
	<div style="text-align: center;">
		<div style="display:inline-block;">
			<form action="BoardWrite.bo" method="post" id="frm">
				<div style="border: 3px black solid; width: 850px; padding: 15px;">
					<div>
						<div style="text-align: center;">
							<div style="display: inline-block;">
							    <div class="form-group">
									<input type="text" class="form-control" placeholder="title" style="width: 766px;" name="subject">
								</div>
							</div>
						</div>
						<div style="text-align: center;">
							<div style="display: inline-block;">
								<div style="width: 768px;">
									<textarea name="content" id="smarteditor" rows="10" cols="60"	style="width: 766px; height: 350px;"></textarea>
								</div>
							</div>
						</div>
						<div style="text-align: right">
							<div style="display: inline-block; padding-top: 15px;">
								<input type="submit" id="savebutton" class="btn btn-primary  btn-lg" value="작성"> 
								<input type="button" class="btn btn-primary  btn-lg" onclick="location.href='BoardList.bo'" value="취소">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		$(function() {
			//전역변수선언
			var editor_object = [];

			nhn.husky.EZCreator.createInIFrame({
				oAppRef : editor_object,
				elPlaceHolder : "smarteditor",
				sSkinURI : "./se2/SmartEditor2Skin.html",
				htParams : {
					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseToolbar : true,
					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : false,
					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true,
				}
			});

			//전송버튼 클릭이벤트
			$("#savebutton").click(
					function() {
						//id가 smarteditor인 textarea에 에디터에서 대입
						editor_object.getById["smarteditor"].exec(
								"UPDATE_CONTENTS_FIELD", []);

						// 이부분에 에디터 validation 검증

						//폼 submit
						$("#frm").submit();
					})
		})
	</script>
</body>
</html>