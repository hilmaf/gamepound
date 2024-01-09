import React from 'react';
import styled from 'styled-components';

const StyledReviewStatsDiv = styled.div`
    color: var(--black-color);
    width: 280px;
    height: 200px;
    display: flex;
    background-color: whitesmoke;
    border-radius: 5px;
    flex-direction: column;
    align-items: center;

    & > .rating_avg {
        padding-top: 30px;
        padding-bottom: 35px;
        display: flex;
        flex-direction: column;
        align-items: center;

        & > #title {
            font-size: 16px;
            font-weight: 500;
        }

        & > #avg {
            font-size: 32px;
            color: var(--red-color);
        }
    }

    & > ul {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 13px;

        & > li {
            padding-left: 10px;
            padding-bottom: 5px;

            & > #rating {
                padding-right: 5px;
                color: rgb(0, 0, 0, 0.7);
            }
            
            & > #cnt {
                padding-right: 5px;
                color: rgb(0, 0, 0, 0.7);
            }
        }
    }
`;

const ReviewStats = () => {
    return (
        <StyledReviewStatsDiv>
            <div className='rating_avg'>
                <div id='title'>ㅇㅇㅇ 님의 프로젝트 만족도</div>
                <div id='avg'>3.5</div>
            </div>
            <ul>
                <li><span id='rating'>1점</span><span id='cnt'>n개</span></li>
                <li><span id='rating'>2점</span><span id='cnt'>n개</span></li>
            </ul>
            <ul>
                <li><span id='rating'>3점</span><span id='cnt'>n개</span></li>
                <li><span id='rating'>4점</span><span id='cnt'>n개</span></li>
                <li><span id='rating'>5점</span><span id='cnt'>n개</span></li>
            </ul>
        </StyledReviewStatsDiv>
    );
};

export default ReviewStats;