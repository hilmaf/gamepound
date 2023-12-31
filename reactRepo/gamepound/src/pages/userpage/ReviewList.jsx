import React from 'react';
import styled from 'styled-components';
import ReviewBox from './ReviewBox';

const StyledReviewListDiv = styled.div`
    width: 800px;
    display: flex;
    flex-direction: column;
    align-items: center;
`;

const ReviewList = () => {
    return (
        <StyledReviewListDiv>
            <ReviewBox />
            <ReviewBox />
            <ReviewBox />
            <ReviewBox />
            <ReviewBox />
        </StyledReviewListDiv>
    );
};

export default ReviewList;