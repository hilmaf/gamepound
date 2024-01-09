import React from 'react';
import styled from 'styled-components';

const StyledProjectBoxInfoDiv = styled.div`
    width: calc(100% / 3 - 30px);
    height: 410px;
    padding-right: 25px;

    & > img {
        width: 100%;
        height: 300px;
        background-size: cover;
        object-fit: cover;
    }

    & > div {
        color: #3d3d3d;
    }

    & > .category {
        padding-top: 10px;
        font-size: 12px;
        opacity: 0.8
    }

    & > .title {
        height: 30px;
        line-height: 30px;
        font-size: 16px;
    }

    & > .progress {
        display: flex;
        justify-content: space-between;

        & > .achievement {

            & > #achievement_rate {
                font-size: 15px;
                font-weight: 900;
                padding-right: 5px;
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

const ProjectBoxInfo = () => {
    return (
        <StyledProjectBoxInfoDiv>
            <img src='https://cdn.akamai.steamstatic.com/steam/apps/416600/capsule_616x353.jpg?t=1689347261'></img>
            <div className='category'>
                <span>카테고리</span>
                <span>창작자</span>
            </div>
            <div className='title'>
                프로젝트 제목
            </div>
            <div className='progress'>
                <div className='achievement'>
                    <span id='achievement_rate'>3812%</span>
                    <span id='achievement_amnt'>24975023원</span>
                </div>
                <div className='status'>
                    펀딩성공
                </div>
            </div>
        </StyledProjectBoxInfoDiv>
    );
};

export default ProjectBoxInfo;