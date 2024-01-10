import React from 'react';
import styled from 'styled-components';
import { useBackingMemory } from '../context/BackingContext';

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

    const contextValue = useBackingMemory();
    const conditionalVo = ProjectBriefInfo===undefined ? contextValue : ProjectBriefInfo;

    return (
        <StyledProjectBriefInfoDiv>
            <img src={conditionalVo.projectImg}/>
            <div className='project_summary'>
                <div className='category'>{conditionalVo.categoryName}</div>
                <div className='title'>{conditionalVo.projectTitle}</div>
                <div className='achievement'>
                    <span>{conditionalVo.currentAmount}</span>
                    <span>{conditionalVo.achievementRate}%</span> 
                    <span>{conditionalVo.remainingPeriod}일 남음</span>
                </div>
            </div>
        </StyledProjectBriefInfoDiv>
    );
};

export default ProjectBriefInfo;