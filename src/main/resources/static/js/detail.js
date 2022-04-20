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

$("#my_btn_vote").click(() => {
    likeUp();
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
        $("#my-modal-text").text("이미 공감한 게시글입니다."); // 수정필요
    } else {
        alert("이 글을 공감할 수 없습니다.");
    }
}
