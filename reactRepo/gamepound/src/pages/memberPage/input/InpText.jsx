import React from 'react';
import styled from 'styled-components';

const StyledInpDiv = styled.div`
    & label {
        display: flex;
        font-size: 13px;
        padding: 3px 0;
    }
    & input {
        display: flex;
        width: 100%;
        padding: 10px 15px;
        font-size: 15px;
        box-sizing: border-box;
        border-radius: 5px;
        border: 1px solid #ddd;
        &::placeholder {
            color: #aaa;
        }
        &:hover,
        &:focus {
            border-color: #333;
            outline: none;
        }
    }
`;

const InpText = ( {name, text, type, onChange} ) => {
    return (
        <StyledInpDiv>
            <label htmlFor={name}>{text}</label>
            <input id={name} name={name} type={type} placeholder={text + '를 입력해주세요.'} onChange={onChange} />
        </StyledInpDiv>
    );
};

export default InpText;