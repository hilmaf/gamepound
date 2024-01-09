import React from 'react';
import styled from 'styled-components';

const StyledReviewWriteDiv = styled.div`
    width: 800px;
    height: 300px;
    margin: auto;
    padding: 30px;
    background-color: aliceblue;
`;

const ReviewWrite = () => {
    return (
        <StyledReviewWriteDiv>
            <form>
                <input type='text' name='title' placeholder=''/>
            </form>
        </StyledReviewWriteDiv>
    );
};

export default ReviewWrite;