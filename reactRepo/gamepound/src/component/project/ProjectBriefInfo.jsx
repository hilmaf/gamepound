import React from 'react';
import styled from 'styled-components';

const StyledProjectBriefInfoDiv = styled.div`
    width: 1200px;
    height: 150px;
    display: flex;
    justify-content: start;
    align-items: center;
    padding-top: 30px;
    padding-bottom: 30px;

    & > img {
        width: 180px;
        height: 120px;
        object-fit: cover;
        padding-left: 10px;
    }

    & > .project_summary {
        margin-left: 20px;

        & > .category {
            font-size: 12px;
            color: #3d3d3d;
            opacity: 0.7;
        }

        & > .title {
            font-size: 28px;
            color: #3d3d3d;
        }

        & > .achievement {
            font-size: 13px;
            color: #3d3d3d;
            
            & > span {
                margin-right: 10px;
            }
        }
    }
    
`;

const ProjectBriefInfo = ({ProjectBriefInfo}) => {
    return (
        <StyledProjectBriefInfoDiv>
            <img src='https://cdn.akamai.steamstatic.com/steam/apps/416600/capsule_616x353.jpg?t=1689347261' alt='프로젝트 이미지'/>
            <div className='project_summary'>
                <div className='category'>카테고리</div>
                <div className='title'>제목</div>
                <div className='achievement'>
                    <span>모인 금액</span>
                    <span>달성률</span> 
                    <span>마감기한 D-</span>
                </div>
            </div>
        </StyledProjectBriefInfoDiv>
    );
};

export default ProjectBriefInfo;