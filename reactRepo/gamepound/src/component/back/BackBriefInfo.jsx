import React, { useState } from 'react';
import styled from 'styled-components';
import ReviewWrite from '../../pages/userpage/ReviewWrite';

const StyledBackBriefInfoDiv = styled.div`
    width: 1200px;
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
            }

            & > #title {
                font-size: 16px;
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

    const [reviewWrite, setReviewWrite] = useState(false);

    const handleReviewWriteBtnClick = () => {
        if(reviewWrite===false) {
            setReviewWrite(true);
        } else {
            setReviewWrite(false);
        }
    }

    return (
        <StyledBackBriefInfoDiv>
            <div className='back_item'>
                <img src={item.projectImg}></img>
                <div className='back_info'>
                    <div id='back_date'>{item.backingDate}</div>
                    <div id='title' key={item.projectTitle}>{item.projectTitle}</div>
                    <div id='reward'>{item.rewardName}</div>
                    <div id='payment_status'>{item.paymentStatus}</div>
                </div>
            </div>
            <button onClick={handleReviewWriteBtnClick}>
                후기 작성
            </button>
            {
                reviewWrite===true
                ?
                <ReviewWrite />
                :
                <></>
            }
        </StyledBackBriefInfoDiv>
    );
};

export default BackBriefInfo;