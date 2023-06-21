// 로그인 버튼 위에 마우스를 올려놓을 때 개인 관리자 텍스트 표시
function showLoginText() {
  const loginText = document.getElementById("loginText");
  loginText.style.visibility = "visible";

  // 텍스트 위에 마우스를 올려놓았을 때 텍스트를 보이도록 설정
  loginText.addEventListener("mouseenter", function () {
    loginText.style.visibility = "visible";
  });

  // 로그인 버튼에서 마우스를 벗어났을 때 텍스트가 사라지도록 설정
  loginText.addEventListener("mouseleave", function () {
    loginText.style.visibility = "hidden";
  });
}

// 로그인 버튼과 개인 관리자 텍스트에서 마우스가 벗어날 때 텍스트 숨김
function hideLoginText() {
  const loginText = document.getElementById("loginText");
  const loginButton = document.querySelector(".loginbutton");

  // 로그인 버튼과 로그인 텍스트의 상호작용을 처리
  loginButton.addEventListener("mouseenter", function () {
    clearTimeout(hideTimer); // hideLoginText 함수가 실행되는 것을 중지
  });

  loginText.addEventListener("mouseenter", function () {
    clearTimeout(hideTimer); // hideLoginText 함수가 실행되는 것을 중지
  });

  let hideTimer; // 숨기는 타이머를 저장하는 변수

  loginButton.addEventListener("mouseout", function () {
    // 로그인 버튼에서 마우스가 벗어날 때 hideLoginText 함수를 지연 실행
    hideTimer = setTimeout(hideLoginText, 200);
  });

  loginText.addEventListener("mouseout", function () {
    // 로그인 텍스트에서 마우스가 벗어날 때 hideLoginText 함수를 지연 실행
    hideTimer = setTimeout(hideLoginText, 200);
  });

  // 로그인 텍스트에서 마우스가 벗어났을 때 텍스트가 사라지도록 설정
  loginText.addEventListener("mouseleave", function () {
    loginText.style.visibility = "hidden";
  });
}



// 로그인 버튼 위에 마우스를 올려놓을 때 개인 관리자 텍스트 표시
function showItemText() {
  const bankItem = document.getElementById("bankItem");
  bankItem.style.visibility = "visible";

  // 텍스트 위에 마우스를 올려놓았을 때 텍스트를 보이도록 설정
  bankItem.addEventListener("mouseenter", function () {
    bankItem.style.visibility = "visible";
  });

  // 로그인 버튼에서 마우스를 벗어났을 때 텍스트가 사라지도록 설정
  bankItem.addEventListener("mouseleave", function () {
    bankItem.style.visibility = "hidden";
  });
}

// 로그인 버튼과 개인 관리자 텍스트에서 마우스가 벗어날 때 텍스트 숨김
function hideItemText() {
  const bankItem = document.getElementById("bankItem");
  const bankItembutton = document.querySelector(".bankItembutton");

  // 로그인 버튼과 로그인 텍스트의 상호작용을 처리
  bankItembutton.addEventListener("mouseenter", function () {
    clearTimeout(hideTimer); // hideLoginText 함수가 실행되는 것을 중지
  });

  bankItem.addEventListener("mouseenter", function () {
    clearTimeout(hideTimer); // hideLoginText 함수가 실행되는 것을 중지
  });

  let hideTimer; // 숨기는 타이머를 저장하는 변수

  bankItembutton.addEventListener("mouseout", function () {
    // 로그인 버튼에서 마우스가 벗어날 때 hideLoginText 함수를 지연 실행
    hideTimer = setTimeout(hideItemText, 200);
  });

  bankItem.addEventListener("mouseout", function () {
    // 로그인 텍스트에서 마우스가 벗어날 때 hideLoginText 함수를 지연 실행
    hideTimer = setTimeout(hideItemText, 200);
  });

  // 로그인 텍스트에서 마우스가 벗어났을 때 텍스트가 사라지도록 설정
  bankItem.addEventListener("mouseleave", function () {
    bankItem.style.visibility = "hidden";
  });
}
