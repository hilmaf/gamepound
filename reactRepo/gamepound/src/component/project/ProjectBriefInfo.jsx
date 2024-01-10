import React, { useEffect, useState } from 'react';
import styled from 'styled-components';

const StyledProjectBriefInfoDiv = styled.div`
    width: 1200px;
    height: 150px;
    display: flex;
    justify-content: start;
    align-items: center;
    padding-top: 30px;
    padding-bottom: 30px;
    color: var(--black-color);

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
            opacity: 0.7;
        }

        & > .title {
            font-size: 28px;
        }

        & > .achievement {
            font-size: 13px;
            
            & > span {
                margin-right: 10px;
            }
        }
    }
    
`;

const ProjectBriefInfo = ({ProjectBriefInfo}) => {  

    return (
        <StyledProjectBriefInfoDiv>
            <img src={ProjectBriefInfo.projectImg}/>
            <div className='project_summary'>
                <div className='category'>{ProjectBriefInfo.categoryName}</div>
                <div className='title'>{ProjectBriefInfo.projectTitle}</div>
                <div className='achievement'>
                    <span>{ProjectBriefInfo.currentAmount}</span>
                    <span>{ProjectBriefInfo.achievementRate}%</span> 
                    <span>{ProjectBriefInfo.remainingPeriod}일 남음</span>
                </div>
            </div>
        </StyledProjectBriefInfoDiv>
    );
};

export default ProjectBriefInfo;