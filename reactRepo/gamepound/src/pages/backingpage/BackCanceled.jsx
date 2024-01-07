import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledBackCanceledDiv = styled.div`
    width: 1200px;
    height: 500px;
    font-size: 32px;
    color: #3d3d3d;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;

    & > :nth-child(2) {
        font-size: 13px;
        color: #3d3d3d;
        padding-top: 6px;
    }

    & > button {
        margin-top: 30px;
        padding: 8px 15px;
        background-color: rgba(255, 145, 77, 0.4);
        color: #3d3d3d;
        cursor: pointer;
    }
`;


const BackCanceled = () => {
    return (
        <StyledBackCanceledDiv>
            <div>후원이 취소되었습니다.</div>
            <div>--후원 마감기한--까지 다시 후원하실 수 있습니다.</div>
            <button><Link to='/back/detail'>후원 상세</Link></button>
        </StyledBackCanceledDiv>
    );
};

export default BackCanceled;