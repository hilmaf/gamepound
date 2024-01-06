import React from 'react';
import styled from 'styled-components';

const StyledProjectBriefInfoDiv = styled.div`
    width: 1200px;
    height: 150px;
    display: flex;
    justify-content: start;
    align-items: center;
`;

const ProjectBriefInfo = () => {
    return (
        <StyledProjectBriefInfoDiv>
            <img />
            <div className='project_summary'>
                <div className='category'>카테고리 카테고리</div>
                <div className='title'>프로젝트 제목</div>
                <div className='achievement'>모인 금액 달성률 마감기한 D-</div>
            </div>
        </StyledProjectBriefInfoDiv>
    );
};

export default ProjectBriefInfo;