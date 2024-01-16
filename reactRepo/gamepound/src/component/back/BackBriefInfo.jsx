import React, { useState } from 'react';
import styled from 'styled-components';
import ReviewWrite from '../../pages/userpage/ReviewWrite';
import { useNavigate } from 'react-router-dom';
import ReviewBox from '../../pages/userpage/ReviewBox';

const StyledBackBriefInfoDiv = styled.div`
    width: 1100px;
    padding: 20px;
    border: 1px solid rgba(0, 0, 0, 0.1);
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    align-items: center;

    & > .back_item {
        display: flex;
        justify-content: space-evenly;
        align-items: center;
        cursor: pointer;
        
        & > img {
            width: 155px;
            height: 120px;
            margin: 0px 20px 0px 0px;
            border: none;
        }

        & > .back_info {
            color: var(--black-color);

            & > #back_date {
               font-size: 12px; 
               opacity: 0.9;
            }

            & > #title {
                font-size: 16px;
                padding-bottom: 20px;
                font-weight: 400;
            }

            & > #reward {
                font-size: 13px;
            }

            & > #payment_status {
                padding-top: 10px;
                font-size: 13px;
                font-weight: 400;
                letter-spacing: 0.4px;
                color: var(--red-color);
            }
        }
    }

    & > button {
        width: 150px;
        height: 46px;
        border: 1px solid var(--red-color);
        background-color: white;
        color: var(--red-color);
        cursor: pointer;
    }
`;

const BackBriefInfo = ({item}) => {

    const navigate = useNavigate();
    const [reviewWrite, setReviewWrite] = useState(false);
    const [reviewView, setReviewView] = useState(false);

    const handleReviewWriteBtnClick = () => {
        if(reviewWrite===false) {
            setReviewWrite(true);
        } else {
            setReviewWrite(false);
        }
    }

    const handleReviewViewBtnClick = () => {
        if(reviewView === false) {
            setReviewView(true);

            fetch("http://127.0.0.1:8889/gamepound/review/")
            .then()
            .then();

        } else {
            setReviewView(false);
        }
    }

    const handleBoxClick = () => {
        navigate("/back/detail/" + item.backNo);
    }

    return (
        <StyledBackBriefInfoDiv>
            <div className='back_item' key={item.backNo} onClick={handleBoxClick}>
                <img src={item.projectImg}></img>
                <div className='back_info'>
                    <div id='back_date'>{item.backingDate}</div>
                    <div id='title'>{item.projectTitle}</div>
                    <div id='reward'>{item.rewardName}</div>
                    <div id='payment_status'>{item.paymentStatus}</div>
                </div>
            </div>
            {
                item.reviewNo === undefined
                ? 
                <button onClick={handleReviewWriteBtnClick}>
                    후기 작성
                </button>
                :
                <button onClick={handleReviewViewBtnClick}>
                    내가 남긴 후기
                </button>
            }
            {
                reviewWrite===true
                ?
                <ReviewWrite item={item}/>
                :
                <></>
            }
            {
                reviewView===true
                ?
                <ReviewBox />
                :
                <></>
            }
        </StyledBackBriefInfoDiv>
    );
};

export default BackBriefInfo;