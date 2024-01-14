import React from 'react';
import styled from 'styled-components';
import ReviewBox from './ReviewBox';

const StyledReviewListDiv = styled.div`
    width: 800px;
    display: flex;
    flex-direction: column;
    align-items: center;
`;

const ReviewList = ({reviewList}) => {

    console.log(reviewList);
    return (
        <StyledReviewListDiv>
            {
                reviewList.map((item)=> (
                    <ReviewBox item={item}/>
                )) 
            } 
        </StyledReviewListDiv>
    );
};

export default ReviewList;