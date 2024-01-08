import React from 'react';
import styled from 'styled-components';

const StyledBackBriefInfoDiv = styled.div`
    width: 1200px;
    height: 140px;
    padding: 20px;
`;

const BackBriefInfo = () => {
    return (
        <StyledBackBriefInfoDiv>
            <div>
                <img></img>
                <div>
                    <div>후원일 or 결제완료일</div>
                    <div>프로젝트 제목</div>
                    <div>선물</div>
                    <div>결제 완료 or 결제예약 취소</div>
                </div>
            </div>
            <button>
                후기 작성
            </button>
        </StyledBackBriefInfoDiv>
    );
};

export default BackBriefInfo;