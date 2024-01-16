import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledProjectBoxInfoDiv = styled.div`
    width: calc(100% / ${no => no.no} - 30px);
    height: ${props => props.no === 3 ? '410px' : '370px'};
    cursor: pointer;
    margin-right: 25px;

    & > img {
        width: 100%;
        height: 205px;
        background-size: cover;
        object-fit: contain;
        background-color: aliceblue;
    }

    & > .category {
        padding-top: 4px;
        font-size: 12px;
        
        & > span {
            opacity: 0.95;
            padding-right: 10px;
        }
    }

    & > .creator {
        padding-top: 8px;
        font-size: 13px;
        color: rgba(0, 0, 0, 0.5);
    }

    & > .title {
        padding-top: 5px;
        height: 50px;
        font-size: 16px;
        /* letter-spacing: 0.01px; */
    }

    & > .progress {
        display: flex;
        justify-content: space-between;

        & > .achievement {

            & > #achievement_rate {
                font-size: 15px;
                font-weight: 600;
                padding-right: 5px;
                color: var(--red-color);
            }

            & > #achievement_amnt {
                font-size: 12px;
            }
        }

        & > .status {
            font-size: 13px;
        }
    }
`;

const ProjectBoxInfo = ({no, project}) => {

    const navigate = useNavigate();

    console.log("ProjectBoxInfo :::!!!!!!!!!" + project);

    const handleBoxClick= () => {
        navigate("/project/detail/" + project.projectNo);
    }

    return (
        <StyledProjectBoxInfoDiv no={no}>
            <img src={project.projectImg} onClick={handleBoxClick} ></img>
            <div className='category'>
                <span>{project.categoryName} | {project.subCategoryName}</span>
            </div>
            <div className='creator'>
                <span>{project.memberName}</span>
            </div>
            <div className='title' onClick={handleBoxClick} key={project.projectNo}>
                {project.projectTitle}
            </div>
            <div className='progress'>
                <div className='achievement'>
                    <span id='achievement_rate'>{project.achievementRate}%</span>
                    <span id='achievement_amnt'>{project.currentAmount}원</span>
                </div>
                <div className='status'>
                    {project.projectStatus}
                </div>
            </div>
        </StyledProjectBoxInfoDiv>
    );
};

export default ProjectBoxInfo;