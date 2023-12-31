<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>테트리스</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="wrapper">
      <!-- 테트리스 게임이 이루어지는 div -->
      <div class="playground">
        <!-- 테트리스 게임이 이루어지는 전체 공간 ul -->
        <div class="start-screen">
          <div class="start-text">
            <h1>테트리스</h1>
            <button class="start-button">시작</button>
          </div>
        </div>
        <div class="game-text">
          <span>게임 종료</span>
          <button>다시 시작</button>
        </div>
        <ul></ul>
        <div class="backcolor"><!-- 점수표 -->
          <div class="score-text"><h1>SCORE</h1></div>
          <div class="score"><b>0</b></div>
          <div class="container2"><div class="highscore"><b>HIGH<br>SCORE</b><div class="highscores">0</div></div></div>
          <div class="container1"><div class="level"><b>LEVEL</b><div class="levels">V.Easy</div></div></div></div>
        <div class="backborder"></div>
        <div></div>
      </div>
    </div>
    <br>
    <div class="container3">
    <div class="guide"><b>조작법<br></br></div>
    <div class="guide-1">기본 조작 ㅣ 블럭 회전<br><a class="play">← ↓ → ㅣ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;↑</a><br /><br />블럭 빠르게 내리기<br>스페이스바<br /><br />
    </div></div>
    <script src="js/tetris.js" type="module"></script>
    <img src="img/background.jpg" alt="" class="backimg">
    <audio src="img/tetris.mp3"></audio>
    <audio src="img/hurryup.mp3"></audio>
    <audio src="img/loose.mp3"></audio>
</body>
</html>