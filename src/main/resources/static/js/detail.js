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
        // $("#my_btn_vote").addClass("my_hidden");
    } else {
        alert("이 글을 공감할 수 없습니다.");
    }
}

 // 스크랩 이벤트
 $("#btn-scrap").click(() => {
    alert("이 글을 스크랩하시겠습니까?");
    scrap();
    scrapUp();
});

// 스크랩하기
async function scrap() {

    let scrapDto = {
        postId: $("#postId").val(),
        userId: $("#userId").val()
    };

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
    } else {
        alert("이미 스크랩한 게시글입니다");
    }
}

// 스크랩카운팅 
async function scrapUp() {

    let postId = $("#postId").val();

    let response = await fetch(`/s/api/post/${postId}/scrap`, {
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        method: 'PUT'
    });

    let responseParse = await response.json();
    if (response.status == 200) {
        $("#scrap-count").text(responseParse.scrapCount);
    } else {
        alert("이미 스크랩한 게시글입니다");
    }
}