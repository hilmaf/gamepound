import React from 'react';
import styled from 'styled-components';

const StyledFooterDiv = styled.div`
    width: 1200px;
    height: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-top: 1px solid #3d3d3d;
    opacity: 0.7;
    
    & > div {
        font-size: 12px;
        color: #3d3d3d;
    }
`;

const Footer = () => {
    return (
        <StyledFooterDiv>
            <div>Designed and Developed by 2ZFunding</div>
        </StyledFooterDiv>
    );
};

export default Footer;