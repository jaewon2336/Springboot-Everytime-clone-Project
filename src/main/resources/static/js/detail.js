let boardNo = $("#boardNo").val();
boardNoCheck();
function boardNoCheck() {
    if (boardNo == 1) {
        $("#my-board-title").text("자유게시판");
    } else if (boardNo == 2) {
        $("#my-board-title").text("비밀게시판");
    } else if (boardNo == 3) {
        $("#my-board-title").text("졸업생게시판");
    } else if (boardNo == 4) {
        $("#my-board-title").text("새내기게시판");
    } else if (boardNo == 5) {
        $("#my-board-title").text("시사·이슈");
    } else if (boardNo == 6) {
        $("#my-board-title").text("장터게시판");
    } else if (boardNo == 7) {
        $("#my-board-title").text("홍보게시판");
    } else if (boardNo == 8) {
        $("#my-board-title").text("동아리·학회");
    } else if (boardNo == 9) {
        $("#my-board-title").text("취업·진로");
    }
}


// 게시글 삭제
$("#btn-delete").click(() => {
    deletePost();
});

async function deletePost() {
    let postId = $("#postId").val();
    let boardNo = $("#boardNo").val();

    let response = await fetch(`/s/api/post/${postId}`, {
        method: "DELETE" // delete는 body가 없다.
    });

    let responseParse = await response.json();

    if (responseParse === 1) {
        alert("삭제되었습니다.");
        location.href = "/s/board/" + boardNo;
    } else {
        alert("삭제에 실패했습니다.");
    }
}

$(".my_btn_vote").click(() => {
    let result = confirm("이 글에 공감하십니까?");
    if (result) {
        likeUp();
    }
});

// 공감
async function likeUp() {

    let postId = $("#postId").val();

    let response = await fetch(`/s/api/post/${postId}/like`, {
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        method: 'PUT'
    });

    let responseParse = await response.json();

    if (response.status == 200) {
        $("#like-count").text(responseParse.likeCount);
        $("#my_btn_vote").attr("disabled", true);
        location.reload();
    } else {
        alert("이 글을 공감할 수 없습니다.");
    }
}

// 스크랩 이벤트
$("#btn-scrap").click(() => {
    let result = confirm("이 글을 스크랩 하시겠습니까?");
    if (result) {
        scrap();
    }
});

// 스크랩하기
async function scrap() {

    let scrapDto = {
        postId: $("#postId").val(),
        userId: $("#userId").val()
    };

    let postId = $("#postId").val();

    let response = await fetch(`/s/api/post/${postId}/scrap`, {
        method: "POST",
        body: JSON.stringify(scrapDto),
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        }
    });

    let responseParse = await response.json();

    if (response.status == 200) {
        alert("스크랩 완료");
        scrapUp(postId);
    } else {
        alert("이미 스크랩한 게시글입니다");
    }
}

// 스크랩카운팅 
async function scrapUp(postId) {

    let response = await fetch(`/s/api/post/${postId}/scrap`, {
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        method: 'PUT'
    });
    let responseParse = await response.json();

    if (response.status == 200) {
        $("#scrap-count").text(responseParse.scrapCount);
    }
}