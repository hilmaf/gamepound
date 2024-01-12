import React from 'react';
import styled from 'styled-components';

const StyledReviewBoxDiv = styled.div`
    width: 760px;
    color: var(--black-color);
    border-bottom: 1px solid rgb(0, 0, 0, 0.1);
    
    & > .writer {
        display: flex;
        justify-content: start;
        padding-top: 15px;
        padding-bottom: 20px;


        & > #profile_img {
            width: 36px; 
            height: 36px;
            border-radius: 36px;
        }

        & > #nick {
            font-size: 14px;
            line-height: 36px;
            padding-left: 20px;
        }
    }

    & > .rating {
        padding-left: 20px;
        & > span {
            font-size: 14px;
            opacity: 0.95;
        }

        & > :nth-child(2) {
            background-color: var(--red-color);
            color: white;
            padding: 1px 7px;
            margin-left: 20px;
            border-radius: 5px;
            opacity: 1.0;
        }
    }

    & .content {
        padding-left: 20px;
        margin: 7.5px 0px 20px;
        
        & > span {
            font-size: 14px;
            opacity: 0.95;
        }
        
        & > :nth-child(2) {
            font-size: 16px;
            padding: 1px 7px;
            margin-left: 23px;
            border-radius: 5px;
            opacity: 1.0;
        }
    }
    
    & .reviewImg {
        margin-left: 20px;
        margin-bottom: 20px;
        width: 100px;
        height: 100px;
        background-color: aquamarine;
    }

    & .project {
        border-radius: 10px;
        background-color: #F0F0F080;
        height: 40px;
        cursor: pointer;
        display: flex;
        align-items: center;
        padding-left: 20px;

        & :hover {
            opacity: 0.7;
        }
        
        & > img {
            width: 25px;
            height: 25px;
            border-radius: 25px;
            background-color: bisque;
        }

        & > div {
            font-size: 14px;
            padding-left: 7.5px;
        }
    }

    & > .enroll_date {
        display: block;
        text-align: right;
        padding-top: 20px;
        font-size: 14px;
        padding-bottom: 30px;
    }
`;

const ReviewBox = ({item}) => {
    return (
        <StyledReviewBoxDiv>
            <div className='writer'>
                <img id='profile_img' src='https://cdn.akamai.steamstatic.com/steam/apps/416600/capsule_616x353.jpg?t=1689347261'></img>
                <div id='nick'>닉네임</div>
            </div>
            <div className='rating'>
                <span>만족도</span>
                <span>2 . 0</span>
            </div>
            <div className='content'>
                <span>후기</span>
                <span>너무너무 재미있어요</span>
            </div>
            <div className='reviewImg'>
                <img src=''></img>
            </div>
            <div className='project'>
                <img></img>
                <div>프로젝트 타이트으으을 짱재밌는 게임</div>
            </div>
            <div className='enroll_date'>
                2024년 1월 9일
            </div>
        </StyledReviewBoxDiv>
    );
};

export default ReviewBox;